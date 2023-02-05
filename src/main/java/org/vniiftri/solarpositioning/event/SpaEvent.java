package org.vniiftri.solarpositioning.event;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.vniiftri.solarpositioning.model.SpaAnswer;

public class SpaEvent extends ApplicationEvent {
    @Getter
    @Setter
    private SpaAnswer spaAnswer;

    public SpaEvent(SpaAnswer spaAnswer) {
        super(spaAnswer);
        this.spaAnswer = spaAnswer;
    }
}

