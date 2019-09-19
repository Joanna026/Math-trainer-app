package pl.joanna026.dwaxdwa.model.services;

import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.Role;
import pl.joanna026.dwaxdwa.model.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority);
    }
}
