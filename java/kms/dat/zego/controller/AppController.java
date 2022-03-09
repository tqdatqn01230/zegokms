package kms.dat.zego.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kms.dat.zego.models.Game;
import kms.dat.zego.service.EmailSenderService;
import kms.dat.zego.service.GameService;

@Controller
public class AppController {
	@Autowired
	private GameService service;
	 @Autowired
	private EmailSenderService mailService;
	@GetMapping("/trangchu")
	public String home(Model model) {
		List<Game> list = service.getAll();
		model.addAttribute("gameList", list);
		return "trangchu";
	}
	@GetMapping("/lienhe")
	public String contact() {
		return "lienhe";
	}
	@GetMapping("/tuyendung")
	public String tuyendung() {
		return "tuyendung";
	}
	@GetMapping("/gioithieu")
	public String introduce() {
		return "gioithieu";
	}
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	@GetMapping("/sendMail")
	public String sendMail(@RequestParam String name,@RequestParam String email,
				@RequestParam String phone, @RequestParam String skype
				, @RequestParam String message,Model model) {
		mailService.SendMaiService("tqdatqn01230@gmail.com","Email: "+email ,
				"Phone: "+phone+"// Skype: "+skype+"\n"+message);
		model.addAttribute("mess","Sending Success");
		return "lienhe";
	}
	@PostMapping("/addGame")
	public String addGame(@RequestParam String name,@RequestParam String desc
			,@RequestParam String app,@RequestParam String chplay
			,@RequestParam MultipartFile img,Model model) throws IllegalStateException, IOException {
		Game game = new Game();
		game.setLinkApp(app);
		game.setLinkCH(chplay);
		game.setDesc(desc);
		game.setName(name);
		String fileName = StringUtils.cleanPath(img.getOriginalFilename());
        String uploadDir = "./src/main/resources/static/img/";
        Path path = Paths.get(uploadDir);
        try{
            if (!Files.exists(path)){
                Files.createDirectories(path);
            }
            InputStream iS= img.getInputStream();
            Path filePath = path.resolve(fileName);
            Files.copy(iS,filePath,StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ex){
            ex.printStackTrace();
        }
		game.setLinkImage("img/"+img.getOriginalFilename());
		service.add(game);
		System.err.println(img.getOriginalFilename()+" "+img.getSize()+" ");
		model.addAttribute("mess","Add success!");
		return "add";
	}
}
