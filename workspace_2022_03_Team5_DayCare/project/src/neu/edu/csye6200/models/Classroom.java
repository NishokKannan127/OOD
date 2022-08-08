package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class Classroom{
	private List<Group> groupList;
	private GroupRule grouprule;
	private boolean isFull;
	
	public Classroom() {
		groupList = new ArrayList<>();
		isFull = false;
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
				break;
			}
		}
		if(!isAdded) {
			Group newGroup = new Group(ed.getUnassignedEmployee());
			newGroup.addStudentDetails(sd);
			groupList.add(newGroup);
			
		}
		
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
