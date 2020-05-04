package edu.depaul.cdm.se.sportmanagementsystem.DTO;

import java.util.ArrayList;
import java.util.List;

import edu.depaul.cdm.se.sportmanagementsystem.entity.ManagersEntity;
import edu.depaul.cdm.se.sportmanagementsystem.entity.PlayerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {
	private Integer id;
    private String firstName;
    private String lastName;
    private String age;
    private ManagerDTO manager;
    
    public static PlayerDTO entityToDTO(PlayerEntity playerEntity) {

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(playerEntity.getId());
        playerDTO.setFirstName(playerEntity.getFirstName());
        playerDTO.setLastName(playerEntity.getLastName());
        playerDTO.setAge(playerEntity.getAge());
        
        return playerDTO;
    }

    public static PlayerDTO entityToDTOWithRelation(PlayerEntity playerEntity) {
    	PlayerDTO dto = entityToDTO(playerEntity);
    	if (playerEntity != null && playerEntity.getManager() != null) {
    		dto.setManager(ManagerDTO.entityToDTO(playerEntity.getManager()));
    	}
    
    	return dto;
    }

    /**
     * List entity to dto list.
     *
     * @param playerEntity the cmd entities
     * @return the list
     */

    public static List<PlayerDTO> listEntityToDTO (List<PlayerEntity> playerEntity) {
        List<PlayerDTO> players = new ArrayList<>();
        for (PlayerEntity entity : playerEntity) {
        	players.add(entityToDTO(entity));
        }
        return players;
    }
    
    public static List<PlayerDTO> listEntityToDTOWithRelation (List<PlayerEntity> playerEntity) {
        List<PlayerDTO> players = new ArrayList<>();
        for (PlayerEntity entity : playerEntity) {
        	players.add(entityToDTOWithRelation(entity));
        }
        return players;
    }
}
