package com.membership.controller;

import com.membership.domain.Role;
import com.membership.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getARole(@PathVariable(name = "id") int id){
        return roleService.findById(id);
    }

    @PostMapping
    public Role addARole(@RequestBody Role role){
        return roleService.save(role);
    }

    @PutMapping("/{id}")
    public Role updateARole(@PathVariable(name = "id") int id, @RequestBody Role role){
       return roleService.update(id, role);
    }

    @DeleteMapping("/{id}")
    public void deleteARole(@PathVariable(name = "id") int id){
        roleService.deleteById(id);
    }
}
