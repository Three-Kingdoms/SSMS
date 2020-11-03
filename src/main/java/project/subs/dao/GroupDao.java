package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.Group;

import java.util.List;

public interface GroupDao extends JpaRepository<Group, Integer> {
    List<Group> findAllById(Integer id);
}
