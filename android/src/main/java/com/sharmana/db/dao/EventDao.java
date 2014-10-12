package com.sharmana.db.dao;

import com.j256.ormlite.dao.Dao;
import com.sharmana.db.SharmanaDBHelper;
import com.sharmana.db.domain.Email;
import com.sharmana.db.domain.Event;
import com.sharmana.db.dto.EventDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by strusov on 12.10.2014.
 */
public class EventDao {

    private Dao<Event, Integer> eventDao;
    private static SharmanaDBHelper sharmanaDBHelper;
    public EventDao(SharmanaDBHelper sharmanaDBHelper) throws SQLException {
        this.sharmanaDBHelper = sharmanaDBHelper;
        eventDao = sharmanaDBHelper.getEventsDao();
    }

    public void insert(List<EventDTO> events) throws Exception {

        List<Event> eventDTOList = new ArrayList<Event>();
        for (EventDTO eventDTO : events) {
            eventDTOList.add(convert(eventDTO));
        }

        final List<Event> eventsToInsert = eventDTOList;
        eventDao.callBatchTasks(new Callable<Void>() {
            public Void call() throws Exception {
                for (Event event : eventsToInsert) {
                    eventDao.create(event);
                }
                return null;
            }
        });
    }

    public void insert(EventDTO eventDTO) throws Exception {
        Event event = convert(eventDTO);
        eventDao.create(event);
    }

    private Event convert(EventDTO eventDTO) throws SQLException {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setExternalId(eventDTO.getId());
        event.setCurrency(eventDTO.getCurrency());
        Dao<Email, Integer> emailDao = sharmanaDBHelper.getEmailDao();
        for(String email : eventDTO.getEmails()) {
            event.addEmail(emailDao, new Email(email));
        }
//        eventDao.create(event);
        return event;
    }
}
