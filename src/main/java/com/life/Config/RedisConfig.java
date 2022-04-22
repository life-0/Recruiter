package com.life.Config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.life.POJO.redis.UserLogoutMessageListener;
import com.life.POJO.redis.UserMessageListener;
import com.life.POJO.redis.UserRegisterMessageListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;

/*
 *@Author: life-0
 *@ClassName: redisConfig
 *@Date: 2022/3/11 11:34
 *TODO @Description: 自己创建一个redis配置模板, 不使用springboot自动配置的

 */
@Configuration
public class RedisConfig {
    //编写自己的RedisTemplate
    //自己定义了一个RedisTemplate

    //这是一个固定模板，拿去可以直接使用
    @Bean
    @ConditionalOnMissingBean(name = "redisTemplates")
    public  RedisTemplate<String, Object> redisTemplates(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        //为了我们自己开发方便，一般直接使用<String,Object>
        RedisTemplate<String, Object> template = new RedisTemplate<> ();
        template.setConnectionFactory (redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object> (Object.class);
        //json序列化配置
        ObjectMapper om = new ObjectMapper ();
        om.setVisibility (PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping (ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        objectJackson2JsonRedisSerializer.setObjectMapper (om);
        //String的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer ();
        //key采用String序列化方式
        template.setKeySerializer (stringRedisSerializer);
        //hash的key也采用String的序列化方式
        template.setHashKeySerializer (stringRedisSerializer);
        //value的序列化方式采用jackson
        template.setValueSerializer (objectJackson2JsonRedisSerializer);
        //hash的value序列化方式采用jackson
        template.setHashValueSerializer (objectJackson2JsonRedisSerializer);
        template.afterPropertiesSet ();

        return template;
    }


    // 配置用户注册消息监听器
    @Bean(name = "userRegisterMessageListenerAdapter")
    public MessageListenerAdapter userRegisterMessageListenerAdapter(UserRegisterMessageListener userRegisterMessageListener) {
        return new MessageListenerAdapter(userRegisterMessageListener);
    }

    // 配置用户注销消息监听器
    @Bean(name = "userLogoutMessageListenerAdapter")
    public MessageListenerAdapter userLogoutMessageListenerAdapter(UserLogoutMessageListener userLogoutMessageListener) {
        return new MessageListenerAdapter(userLogoutMessageListener);
    }

    // 配置用户消息(包括注册、注销等)监听器
    @Bean(name = "userMessageListenerAdapter")
    public MessageListenerAdapter userMessageListenerAdapter(UserMessageListener userMessageListener) {
        // 可指定订阅者接受消息的方法
        return new MessageListenerAdapter(userMessageListener, "receiveMessage");
    }


    // 将消息监听器绑定到消息容器
    @Bean
    public RedisMessageListenerContainer messageListenerContainer(
            LettuceConnectionFactory lettuceConnectionFactory,
            MessageListenerAdapter userRegisterMessageListenerAdapter,
            MessageListenerAdapter userLogoutMessageListenerAdapter,
            MessageListenerAdapter userMessageListenerAdapter
    ) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(lettuceConnectionFactory);

        // 订阅用户注册消息话题
        container.addMessageListener(userRegisterMessageListenerAdapter, new ChannelTopic(UserRegisterMessageListener.TOPIC_NAME));

        // 订阅用户注销消息话题
        container.addMessageListener(userLogoutMessageListenerAdapter, new ChannelTopic (UserLogoutMessageListener.TOPIC_NAME));

        // 订阅用户消息(包括注册、注销等)话题
        container.addMessageListener(userMessageListenerAdapter, new PatternTopic(UserMessageListener.TOPIC_NAME));

        return container;
    }

}
