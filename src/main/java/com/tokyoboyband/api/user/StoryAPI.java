package com.tokyoboyband.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.dto.Message;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.service.impl.CollectionStoryService;
import com.tokyoboyband.service.impl.StoryService;

@RestController(value = "storyAPIOfUser")
public class StoryAPI {
	@Autowired
	private StoryService storyService;
	@Autowired
	private CollectionStoryService collectionStoryService;
	
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
	
	@PutMapping("/api/updateStory")
	public StoryDTO updatedNew(@RequestBody StoryDTO storyDTO) {
		StoryDTO result = storyService.save(storyDTO);
		Message message = new Message();
		if(result != null) {
			message.success("Chỉnh sửa truyện thành công");
		}
		else {
			message.danger("Chỉnh sửa truyện thất bại");
		}
		result.setMessage(message);
		return result;
	}
	
	@DeleteMapping("/api/xoa-truyen")
	public StoryDTO deletedNew(@RequestBody StoryDTO storyDTO) {
		StoryDTO result = new StoryDTO();
		storyService.delete(storyDTO);
		Message message = new Message();
		message.success("Xóa thành công");
		result.setMessage(message);
		return result;
	}
	
	@PostMapping("/api/updateCollectionStory")
	public CollectionStoryDTO createCollectionStory(@RequestBody CollectionStoryDTO collectionStoryDTO) {
		CollectionStoryDTO result = collectionStoryService.save(collectionStoryDTO);
		Message message = new Message();
		if(result != null) {
			message.success("Thêm mới tập truyện thành công");
		}
		else {
			message.danger("Thêm truyện tập mới thất bại");
		}
		result.setMessage(message);
		return result;
	}
	
	@PutMapping("/api/updateCollectionStory")
	public CollectionStoryDTO UpdatedCollectionStory(@RequestBody CollectionStoryDTO collectionStoryDTO) {
		CollectionStoryDTO result = collectionStoryService.save(collectionStoryDTO);
		Message message = new Message();
		if(result != null) {
			message.success("Chỉnh sửa tập truyện thành công");
		}
		else {
			message.danger("Chỉnh sửa tập truyện thất bại");
		}
		result.setMessage(message);
		return result;
	}
	
	@DeleteMapping("/api/xoa-tap-truyen")
	public CollectionStoryDTO DeletedCollectionStory(@RequestBody CollectionStoryDTO collectionStoryDTO) {
		CollectionStoryDTO result = new CollectionStoryDTO();
		collectionStoryService.deleteOneById(collectionStoryDTO.getId());
		Message message = new Message();
		message.success("Xóa thành công");
		result.setStory_id(collectionStoryDTO.getStory_id());
		result.setMessage(message);
		return result;
	}
}
