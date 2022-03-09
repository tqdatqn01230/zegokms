package kms.dat.zego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kms.dat.zego.Repository.GameRepository;
import kms.dat.zego.models.Game;

@Service
public class GameService {
	@Autowired
	private GameRepository repo;
	public List<Game> getAll(){
		return repo.findAll();
	}
	public void add(Game game) {
		repo.save(game);
	}
}
