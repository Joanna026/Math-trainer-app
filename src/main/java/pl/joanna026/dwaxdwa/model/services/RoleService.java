package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.Role;

public interface RoleService  {

    Role findByAuthority(String authority);
}
