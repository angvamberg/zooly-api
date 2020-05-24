package br.com.truvainfo.zoolyapi.service;

import br.com.truvainfo.zoolyapi.domain.dto.TaskDto;
import br.com.truvainfo.zoolyapi.domain.mapper.TaskMapper;
import br.com.truvainfo.zoolyapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.truvainfo.zoolyapi.domain.enums.TaskStatus.*;
import static java.util.Objects.*;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	public static final String MSG_ERROR_TASK_ID = "msg.error.task.id";
	
	private final TaskRepository taskRepository;
	private final TaskMapper taskMapper;
	
	public List<TaskDto> findAllTasks() {
		return taskMapper.toDtoList(taskRepository.findAll());
	}
	
	public List<TaskDto> findUserTasks(final Integer userId) {
		return taskMapper.toDtoList(taskRepository.findAllByResponsibleUserId(userId));
	}
	
	public List<TaskDto> findAnimalTasks(final Integer animalId) {
		return taskMapper.toDtoList(taskRepository.findAllByAnimalId(animalId));
	}
	
	public void saveTask(final TaskDto taskDto) {
		
		if (isNull(taskDto.getTaskStatus())) {
			taskDto.setTaskStatus(UNCOMPLETED);
		}
		
		taskRepository.save(taskMapper.toEntity(taskDto));
	}
	
	public void deleteTask(final Integer taskId) {
		taskRepository.delete(taskRepository.findById(taskId)
		                                    .orElseThrow(
				                                    () -> new IllegalArgumentException(MSG_ERROR_TASK_ID + taskId)));
	}
	
}
