package org.devalurum.solarpositioning.model.strategy.save.impl;

import lombok.RequiredArgsConstructor;
import org.devalurum.solarpositioning.service.FileService;
import org.springframework.stereotype.Component;
import org.devalurum.solarpositioning.model.SpaAnswer;
import org.devalurum.solarpositioning.model.strategy.Answer;
import org.devalurum.solarpositioning.model.strategy.save.SaveStrategy;

import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class SaveYesStrategy implements SaveStrategy<Path> {

    private final FileService fileService;
    @Override
    public Path save(SpaAnswer request) {
        return fileService.save(request.toString());
    }

    @Override
    public Answer getAnswer() {
        return Answer.YES;
    }
}
