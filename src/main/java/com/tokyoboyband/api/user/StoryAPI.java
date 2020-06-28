package com.tokyoboyband.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tokyoboyband.dto.Message;
import com.tokyoboyband.dto.RoleDTO;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.service.impl.StoryService;

@RestController(value = "storyAPIOfUser")
public class StoryAPI {
	@Autowired
	private StoryService storyService;
	
	@PostMapping("/api/updateStory")
	public StoryDTO createNew(@RequestBody StoryDTO storyDTO) {
		StoryDTO result = storyService.save(storyDTO);
		Message message = new Message();
		if(result != null) {
			message.success("Thêm mới truyện thành công");
		}
		else {
			message.danger("Thêm truyện mới thất bại");
		}
		result.setMessage(message);
		return result;
	}
}
