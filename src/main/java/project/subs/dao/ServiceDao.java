package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.Service;
import project.subs.bean.ServiceType;
import project.subs.bean.UserSubs;

import java.util.List;

public interface ServiceDao extends JpaRepository<Service, Integer> {
    List<Service> findByServiceType(ServiceType serviceType);
}


