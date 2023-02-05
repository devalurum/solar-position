package org.vniiftri.solarpositioning.model.strategy.save.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.vniiftri.solarpositioning.model.SpaAnswer;
import org.vniiftri.solarpositioning.model.strategy.Answer;
import org.vniiftri.solarpositioning.model.strategy.save.SaveStrategy;
import org.vniiftri.solarpositioning.service.FileService;

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
