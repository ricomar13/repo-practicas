package clonesKamino.controllers;

import clonesKamino.domain.CloneTrooper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneService {

    @Autowired //inyeccion de dependencias.
    private CloneRepository cloneRepository;

    public void guardar(CloneTrooper cloneTrooper){
        cloneRepository.save(cloneTrooper);
    }
}
