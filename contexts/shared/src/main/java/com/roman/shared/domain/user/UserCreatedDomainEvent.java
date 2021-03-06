package com.roman.shared.domain.user;

import com.roman.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class UserCreatedDomainEvent extends DomainEvent {
    private final String username;
    private final String password;
    private final String name;
    private final String lastname;

    public UserCreatedDomainEvent() {
        super(null);

        this.username = null;
        this.password = null;
        this.name = null;
        this.lastname = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String username, String password, String name, String lastname) {
        super(aggregateId);

        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public UserCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String username, String password, String name, String lastname) {
        super(aggregateId, eventId, occurredOn);

        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public String name() {
        return name;
    }

    public String lastname() {
        return lastname;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {
            {
                put("id", aggregateId());
                put("username", username);
                put("password", password);
                put("name", name);
                put("lastname", lastname);
            }
        };
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UserCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("username"),
                (String) body.get("password"), (String) body.get("name"), (String) body.get("lastname"));
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}
