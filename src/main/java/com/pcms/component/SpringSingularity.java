/**
 * Created on Sep 6, 2018, 7:16:32 PM
 *
 * Copyright(c) 2018 ShadowOfLies. All Rights Reserved.
 * The code from this class and all associated code, with the exception of third
 * party library code, is the proprietary information of ShadowOfLies.
 */
package com.pcms.component;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @version 1
 * @author Gavin Boshoff
 */
@Component
public class SpringSingularity {

    private static ApplicationContext applicationContext;

    /**
     * Retrieves a unique instance of the specified bean type. This will ensure
     * that there only ever exists a single instance of the bean after it has
     * been instantiated by the {@code Spring} bean factory.<br>
     * <br>
     * Using this method only ensures that the singleton instance of the
     * existing bean is retrieved, although if additional instances have been
     * created and reside within the bean factory, an error will be raised.
     *
     * @param <T> The type of bean which is in question
     * @param beanClazz The {@code Class} type identifying the bean which will
     *      be returned
     *
     * @return The singleton bean instance of the specified type, if any
     *
     * @throws NoSuchBeanDefinitionException If no bean of the given type was
     *      found
     * @throws NoUniqueBeanDefinitionException If more than one bean of the
     *      given type was found
     */
    public static <T> T getSingletonBean(Class<T> beanClazz)
            throws NoSuchBeanDefinitionException, NoUniqueBeanDefinitionException {
        return applicationContext.getBean(beanClazz);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringSingularity.applicationContext = applicationContext;
    }
}
