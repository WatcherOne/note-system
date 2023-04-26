package watcher.cloud.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import watcher.cloud.dto.NoteAddDto;
import watcher.cloud.dto.NoteQueryDto;
import watcher.cloud.dto.NoteUpdateDto;
import watcher.cloud.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import watcher.cloud.vo.NoteListVo;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/getList")
    public List<NoteListVo> getList(@RequestBody NoteQueryDto queryDto) {
        return noteService.getList(queryDto);
    }

    @PostMapping("/add-wa-zb")
    public int add(@Validated @RequestBody NoteAddDto addDto) {
        return noteService.add(addDto);
    }

    @PostMapping("/edit-wa-zb")
    public int edit(@Validated @RequestBody NoteUpdateDto updateDto) {
        return noteService.edit(updateDto);
    }

    @GetMapping("/getDetail/{id}")
    public NoteListVo detail(@PathVariable(name = "id") String id) {
        return noteService.detail(id);
    }
}
