package com.roman.wallet.transactions.domain.bus.event;

import com.roman.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class WithdrawTransactionDomainEvent extends DomainEvent {
    private final String id;
    private final String origin;
    private final String destination;
    private final Float quantity;
    private final String type;
    private final String concept;

    public WithdrawTransactionDomainEvent() {
        this.id = null;
        this.origin = null;
        this.destination = null;
        this.quantity = null;
        this.type = null;
        this.concept = null;
    }

    public WithdrawTransactionDomainEvent(String id, String origin, String destination, Float quantity, String type, String concept) {
        super(null);

        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
        this.type = type;
        this.concept = concept;
    }

    public WithdrawTransactionDomainEvent(String aggregateId, String eventId, String occurredOn, String id, String origin, String destination, Float quantity, String type, String concept) {
        super(aggregateId, eventId, occurredOn);

        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
        this.type = type;
        this.concept = concept;
    }

    public WithdrawTransactionDomainEvent(String aggregateId, String id, String origin, String destination, Float quantity, String type, String concept) {
        super(aggregateId);

        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
        this.type = type;
        this.concept = concept;
    }

    public String id() {
        return id;
    }

    public String origin() {
        return origin;
    }

    public String destination() {
        return destination;
    }

    public Float quantity() {
        return quantity;
    }

    public String type() {
        return type;
    }

    public String concept() {
        return concept;
    }

    @Override
    public String eventName() {
        return "transaction.transfer";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("id", id);
            put("origin", origin);
            put("destination", destination);
            put("quantity", quantity);
            put("type", type);
            put("concept", concept);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new WithdrawTransactionDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("id"),
                (String) body.get("origin"),
                (String) body.get("destination"),
                (Float) body.get("quantity"),
                (String) body.get("type"),
                (String) body.get("concept")
        );
    }
}
