package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classroom{
	private List<Group> groupList;
	private long id;
	private GroupRule grouprule;
	private boolean isFull;
	private String classroomname;
	
	public Classroom() {
		groupList = new ArrayList<>();
		isFull = false;
		long leftLimit = 1000L;
	    long rightLimit = 10000L;
	    this.id = leftLimit + (long) (new Random().nextFloat() * (rightLimit - leftLimit));
	    this.classroomname = "Class ".concat(String.valueOf(id));
	}
	
	public void addStudent(StudentDetails sd, EmployeeDirectory ed) {
		boolean isAdded = false;
		for(Group g:groupList) {
			if(g.getStudDetailsList().size() < grouprule.getSize()) {
				g.addStudentDetails(sd);
				isAdded = true;
				if(g.getStudDetailsList().size() == grouprule.getSize() && groupList.size() == grouprule.getMax()) {
					isFull = true;
				}
				sd.setGroup(g);
				sd.setClassroom(this);
				break;
			}
		}
		if(!isAdded) {
			Group newGroup = new Group(ed.getUnassignedEmployee());
			newGroup.addStudentDetails(sd);
			groupList.add(newGroup);
			sd.setGroup(newGroup);
			sd.setClassroom(this);
		}
		
		System.out.println("Group id"+ sd.getGroupid());
		System.out.println("Class id"+ sd.getClassid());
		
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassroomname() {
		return classroomname;
	}

	public void setClassroomname(String classroomname) {
		this.classroomname = classroomname;
	}

	public void addGroup(Group group) {
		groupList.add(group);
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	public GroupRule getGrouprule() {
		return grouprule;
	}

	public void setGrouprule(GroupRule grouprule) {
		this.grouprule = grouprule;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	

}
