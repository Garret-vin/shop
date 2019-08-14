package com.service.impl;

import com.model.Code;
import com.model.User;
import com.repository.CodeRepository;
import com.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CodeServiceImpl implements CodeService {

    private CodeRepository codeRepository;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public CodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    @Transactional
    public void add(Code code) {
        codeRepository.save(code);
        logger.info(code + " was added to DB");
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Code> getById(Long id) {
        return codeRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Code> getLastCodeForUser(User user) {
        return codeRepository.findFirstByUserOrderByIdDesc(user);
    }
}
