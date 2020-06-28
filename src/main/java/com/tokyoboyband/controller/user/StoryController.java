package com.tokyoboyband.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tokyoboyband.dto.CollectionStoryDTO;
import com.tokyoboyband.dto.StoryDTO;
import com.tokyoboyband.service.impl.CollectionStoryService;
import com.tokyoboyband.service.impl.StoryService;

@Controller(value = "storyControllerOfWeb")
public class StoryController {
	@Autowired
	private StoryService storyService;
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
	public ModelAndView showListDetailCollectionStory(@RequestParam("idCollectionStory") Long idFindCollectionStory, @RequestParam("idStory") Long idFindStory) {
		ModelAndView mav = new ModelAndView("user/detailcollectionstory");
		StoryDTO story = storyService.findOneById(idFindStory);
		mav.addObject("story", story);
		CollectionStoryDTO collectionStory = collectionStoryService.findOneById(idFindCollectionStory);
		mav.addObject("collectionStory", collectionStory);
		return mav;
	}
}
