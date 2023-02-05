package org.devalurum.solarpositioning.event;


import lombok.Getter;
import lombok.Setter;
import org.devalurum.solarpositioning.model.SpaAnswer;
import org.springframework.context.ApplicationEvent;

public class SpaEvent extends ApplicationEvent {
    @Getter
    @Setter
    private SpaAnswer spaAnswer;

    public SpaEvent(SpaAnswer spaAnswer) {
        super(spaAnswer);
        this.spaAnswer = spaAnswer;
    }
}

