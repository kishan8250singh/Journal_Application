package com.JavaBacked.journal.Controller;

import com.JavaBacked.journal.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
  public Map<Long,JournalEntry> journalEntryMap = new HashMap<>();
  @GetMapping
  public ArrayList<JournalEntry> getAll(){
    return new ArrayList<>(journalEntryMap.values());
  }

  @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry){
       journalEntryMap.put(myentry.getId(),myentry);
       return true;
  }

  @GetMapping("id/{myid}")
    public JournalEntry GetJournalEntry(@PathVariable Long myid){
      return journalEntryMap.get(myid);
  }

  @DeleteMapping("id/{myid}")
    public JournalEntry DeleteJournalEntryById(@PathVariable Long myid){
      return journalEntryMap.remove(myid);
  }
  @PutMapping("id/{myid}")
  public  JournalEntry updatejournalEntry(@PathVariable Long myid,@RequestBody JournalEntry myentry){
   return journalEntryMap.put(myid,myentry);
  }
}
