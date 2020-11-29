package project.subs.service;

import project.subs.bean.Service;
import project.subs.bean.ServiceType;

import java.util.List;

public interface ServiceService {
    List<Service> findAllService(ServiceType serviceType);

    Service findByServiceNameAndAndServiceType(String serviceName, ServiceType serviceType);

    Service findServiceById(Integer serviceId);
}
