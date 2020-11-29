package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import project.subs.bean.Service;
import project.subs.bean.ServiceType;
import project.subs.dao.ServiceDao;
import project.subs.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceSerivceImpl implements ServiceService {

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public List<Service> findAllService(ServiceType serviceType) {
        return serviceDao.findByServiceType(serviceType);
    }

    @Override
    public Service findByServiceNameAndAndServiceType(String serviceName, ServiceType serviceType) {
        return serviceDao.findByServiceNameAndAndServiceType(serviceName, serviceType);
    }

    @Override
    public Service findServiceById(Integer serviceId) {
        return serviceDao.findServiceById(serviceId);
    }
}
