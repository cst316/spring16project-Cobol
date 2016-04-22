package net.sf.memoranda;

import java.util.Date;
import java.util.*;
import net.sf.memoranda.date.CalendarDate;

public class TaskTemplateImpl implements TaskTemplate 
{
	//Fields to populate 
		CalendarDate calendarDateStart;
		
		CalendarDate calendarDateEnd;
		
		int progressToSet;
		
		int priorityToSet;
		
		String textToSet;
		
		long effortToSet;
		
		String descriptionToSet;
	
	public TaskTemplateImpl(int autoFillNum)
	{
		if(autoFillNum == 0)
		{
			Calendar calendar = Calendar.getInstance();

			Date BeginDate = calendar.getTime();
			calendarDateStart = new CalendarDate(BeginDate);
			
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			Date EndDate = calendar.getTime();
			calendarDateEnd = new CalendarDate(EndDate);
			
			progressToSet = 0;
			
			priorityToSet = 0;
			
			textToSet = "This is Standard Template Task";
			
			effortToSet = 0;
			
			descriptionToSet = "This is Standard Template";
		}
		else if(autoFillNum < 0)
		{
			// Add more variety
		}
		else
		{
			System.out.println("Invalid AutoFillNum");
		}
	}
	
	public Task createTask()
	{
		Task taskToPopulate = CurrentProject.getTaskList().createTask(calendarDateStart, calendarDateEnd, textToSet, progressToSet, priorityToSet, textToSet, null);
		return taskToPopulate;
	}
}
