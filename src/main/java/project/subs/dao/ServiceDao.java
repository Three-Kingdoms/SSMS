package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.Service;
import project.subs.bean.ServiceType;

import java.util.List;

public interface ServiceDao extends JpaRepository<Service, Integer> {
    List<Service> findByServiceType(ServiceType serviceType);

    Service findByServiceNameAndAndServiceType(String serviceName, ServiceType serviceType);

    Service findServiceByServiceName(String serviceName);

    Service findServiceById(Integer serviceId);
}


