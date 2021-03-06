package br.com.truvainfo.zoolyapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.*;

@Getter
@Setter
public class AnimalDTO implements Serializable {
	
	private Integer id;
	
	private String popularName;
	
	private String nickname;
	
	private String scientificName;
	
	private String note;
	
	@JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date creationDate;
	
	private List<TaskDTO> tasks;
	
	private List<BiometryDTO> biometrics;
	
}
