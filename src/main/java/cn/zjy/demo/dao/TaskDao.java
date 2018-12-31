package cn.zjy.demo.dao;

import cn.zjy.demo.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface TaskDao {

    List<Task> queryByMemory();

    List<Task> queryByInnodb();
}
