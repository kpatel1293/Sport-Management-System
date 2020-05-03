package edu.depaul.cdm.se.sportmanagementsystem.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import edu.depaul.cdm.se.sportmanagementsystem.entity.ManagersEntity;
import lombok.Getter;
import lombok.Setter;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * The type Commande dto.
 */
@Getter
@Setter
public class ManagerDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private String team;
	private List<PlayerDTO> listPlayer;

	public static ManagerDTO entityToDTO(ManagersEntity manager) {

		ManagerDTO managerDTO = new ManagerDTO();
		managerDTO.setId(manager.getId());
		managerDTO.setFirstName(manager.getFirstName());
		managerDTO.setLastName(manager.getLastName());
		managerDTO.setTeam(manager.getTeam());

		return managerDTO;
	}

	public static ManagerDTO entityToDTOWithRelation(ManagersEntity manager) {
		ManagerDTO dto = entityToDTO(manager);
		if (manager != null && manager.getListPlayers() != null) {
			dto.setListPlayer(PlayerDTO.listEntityToDTO(manager.getListPlayers()));
		}

		return dto;
	}

	/**
	 * List entity to dto list.
	 *
	 * @param managersEntity the cmd entities
	 * @return the list
	 */

	public static List<ManagerDTO> listEntityToDTO(List<ManagersEntity> managersEntity) {
		List<ManagerDTO> managers = new ArrayList<>();
		for (ManagersEntity entity : managersEntity) {
			managers.add(entityToDTO(entity));
		}
		return managers;
	}
	
	public static List<ManagerDTO> listEntityToDTOWithRelation (List<ManagersEntity> managersEntity) {
        List<ManagerDTO> managers = new ArrayList<>();
        for (ManagersEntity entity : managersEntity) {
        	managers.add(entityToDTOWithRelation(entity));
        }
        return managers;
    }

}
