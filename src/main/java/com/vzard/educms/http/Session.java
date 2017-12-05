package com.vzard.educms.http;


import java.util.Map;

public interface Session {

    /**
     * Get current session id
     * @return
     */
    String id();

    /**
     * Set session id
     * @param id
     */
    void id(String id);

    /**
     * Get current session client address
     * @return
     */
    String ip();

    /**
     * Set current session client ip address
     * @param ip
     */
    void ip(String ip);

    /**
     * Get current session attribute by name
     * @param name
     * @param <T>
     * @return
     */
    <T> T attribute(String name);

    /**
     * Set current session attribute
     * @param name
     * @param value
     */
    void attribute(String name,Object value);

    /**
     * Get current session attributes
     * @return
     */
    Map<String,Object> attributes();

    default void remove(String name){
        removeAttribute(name);
    }

    /**
     * Remove current session attribute
     * @param name
     */
    void removeAttribute(String name);

    /**
     * Get current session create unix time
     * @return
     */
    long created();

    /**
     * Set current session expired unix time
     * @param created
     */
    void create(Long created);

    /**
     * Get current session expired unix time
     * @return
     */
    Long expired();

    /**
     * Set session expired unix time
     * @param expired
     */
    void expired(Long expired);


}
