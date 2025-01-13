package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tpguides.repository.CommentRepository;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

}
