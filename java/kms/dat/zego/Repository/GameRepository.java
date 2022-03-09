package kms.dat.zego.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kms.dat.zego.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
	
}
