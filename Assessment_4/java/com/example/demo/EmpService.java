package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository repo;

    public List<Emp> getAll() {
        return repo.findAll();
    }

    public Emp getById(Integer id) {  
        return repo.findById(id).orElseThrow();
    }

    public void delete(Integer id) {  
        repo.deleteById(id);
    }

    public Emp save(Emp emp) {
        return repo.save(emp);
    }
}