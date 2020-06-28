package com.tokyoboyband.controller.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tokyoboyband.dto.CategoryDTO;
import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.dto.Message;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.service.impl.CategoryService;
import com.tokyoboyband.service.impl.CollectionStoryService;
import com.tokyoboyband.service.impl.StoryService;
import com.tokyoboyband.utils.SecurityUtils;

@Controller(value = "storyControllerOfWeb")
public class StoryController {
	@Autowired
	private StoryService storyService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CollectionStoryService collectionStoryService;

	@RequestMapping(value = "/truyen", method = RequestMethod.GET)
	public ModelAndView showListCollectionStory(@RequestParam("idStory") Long idFindStory) {
		ModelAndView mav = new ModelAndView("user/collectionstory");
		StoryDTO story = storyService.findOneById(idFindStory);
		mav.addObject("story", story);
		return mav;
	}

	@RequestMapping(value = "/tap-truyen", method = RequestMethod.GET)
	public ModelAndView showListDetailCollectionStory(@RequestParam("idCollectionStory") Long idFindCollectionStory,
			@RequestParam("idStory") Long idFindStory) {
		ModelAndView mav = new ModelAndView("user/detailcollectionstory");
		StoryDTO story = storyService.findOneById(idFindStory);
		mav.addObject("story", story);
		CollectionStoryDTO collectionStory = collectionStoryService.findOneById(idFindCollectionStory);
		mav.addObject("collectionStory", collectionStory);
		return mav;
	}

	@RequestMapping(value = "/ke-sach", method = RequestMethod.GET)
	public ModelAndView showListMyStory(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/userbookshelf");
		StoryDTO story = new StoryDTO();
		story.setListResult((ArrayList<StoryDTO>) storyService.findByCreatedByOrModifiedBy(SecurityUtils.getUsername()));
		Message messageOb = new Message();

			messageOb.setAlert(request.getParameter("alert"));
			messageOb.setMessage(request.getParameter("message"));
			story.setMessage(messageOb);

		mav.addObject("story", story);
		return mav;
	}

	@RequestMapping(value = "/ke-sach/them-truyen", method = RequestMethod.GET)
	public ModelAndView AddNewStory() {
		ModelAndView mav = new ModelAndView("user/updatestory");
		CategoryDTO categoryList = new CategoryDTO();
		categoryList.setListResult((ArrayList<CategoryDTO>) categoryService.findAll());
		mav.addObject("category", categoryList);
		mav.addObject("action", "POST");
		StoryDTO story = new StoryDTO();
		story.setId(-1l);
		mav.addObject("story", story);
		return mav;
	}
	
	@RequestMapping(value = "/ke-sach/chinh-sua", method = RequestMethod.GET)
	public ModelAndView UpdatedStory(@RequestParam("idStory") Long idStory) {
		ModelAndView mav = new ModelAndView("user/updatestory");
		CategoryDTO categoryList = new CategoryDTO();
		categoryList.setListResult((ArrayList<CategoryDTO>) categoryService.findAll());
		mav.addObject("category", categoryList);
		mav.addObject("action", "PUT");
		StoryDTO story = storyService.findOneById(idStory);
		//story.setCategory_id(idStory);
		mav.addObject("story", story);
		return mav;
	}
	
	@RequestMapping(value = "/ke-sach/danh-sach-tap-truyen", method = RequestMethod.GET)
	public ModelAndView showChangeListCollectionStory(@RequestParam("idStory") Long idStory, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("user/usercollectionbookshelf");
		StoryDTO story = storyService.findOneById(idStory);
		Message messageOb = new Message();
		messageOb.setAlert(request.getParameter("alert"));
		messageOb.setMessage(request.getParameter("message"));
		story.setMessage(messageOb);
		mav.addObject("story", story);
		return mav;
	}
	
	@RequestMapping(value = "/ke-sach/danh-sach-tap-truyen/them-tap-truyen", method = RequestMethod.GET)
	public ModelAndView NewCollectionStory(@RequestParam("idStory") Long idStory) {
		ModelAndView mav = new ModelAndView("user/updatecollectionstory");
		StoryDTO story = storyService.findOneById(idStory);
		CollectionStoryDTO collectionStoryDto = new CollectionStoryDTO();
		collectionStoryDto.setId(-1l);
		collectionStoryDto.setStory_id(idStory);
		mav.addObject("collectionstory", collectionStoryDto);
		mav.addObject("story", story);
		mav.addObject("action", "POST");
		return mav;
	}
}
