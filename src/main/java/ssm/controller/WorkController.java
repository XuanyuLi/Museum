package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import ssm.model.Work;
import ssm.service.WorkService;
import ssm.util.Constant;
import ssm.util.FileUpload;


@Controller
@RequestMapping("work")
public class WorkController extends BaseController {

    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    private static String getPhotoFileName() {
        return Long.toString(System.nanoTime());
    }

    public void main(String[] args) {
        System.out.println(getPhotoFileName());
    }

    @RequestMapping("create")
    private String create(Work work, @RequestParam MultipartFile pictureFile) {
        String photoPath = application.getRealPath(Constant.UPLOAD_PHOTO_PATH);
        work.setPicture(ssm.util.FileUpload.upload(photoPath,pictureFile));
        workService.create(work);
        return "redirect:/work/queryAll";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        workService.remove(id);
        return "redirect:/work/queryAll";
    }

    @RequestMapping("modify")
    private String modify(Work work,@RequestParam MultipartFile pictureFile) {
        if (!pictureFile.isEmpty()) {
            String photoPath = application.getRealPath(Constant.UPLOAD_PHOTO_PATH);
            work.setPicture(FileUpload.upload(photoPath, pictureFile));
        }
        workService.modify(work);
        return "redirect:/work/queryAll";
    }

    @RequestMapping("queryAll/{page}")
    private String queryAll(@PathVariable int page) {
        session.setAttribute("pagination", workService.queryAll(page));
        return "redirect:/work/list.jsp";
    }

    @RequestMapping("queryAll")
    private String queryAll() {
        return queryAll(1);
    }

    @RequestMapping("queryById/{id}")
    private String queryById(@PathVariable("id") Integer id) {
        session.setAttribute("work", workService.queryById(id));
        return "redirect:/work/edit.jsp";
    }

    @RequestMapping("queryWorks/{currentPage}")
    private String queryWorks(@PathVariable int currentPage) {
        session.setAttribute("pagination", workService.query("queryWorks", null, currentPage));
        return "redirect:/work/works.jsp";
    }


    @RequestMapping("queryWorks")
    private String queryWorks() {
        return queryWorks(1);
    }
}
