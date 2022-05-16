package com.membership.service;


import com.membership.domain.Role;

import java.util.List;

public interface RoleService {
   public List<Role> findAll();
   public Role findById(int id);
   public Role save(Role role);
   public Role update(int id, Role role);
   public void deleteById(int id);

}
