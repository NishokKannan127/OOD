package neu.edu.csye6200.models;

import java.util.ArrayList;
import java.util.List;

public class ClassroomDirectory {
	private List<Classroom> classRoomDir;
	
	public ClassroomDirectory() {
		this.classRoomDir = new ArrayList<>();
	}
	
	public void addClassroom(Classroom classroom) {
		this.classRoomDir.add(classroom);
	}
	
	public List<Classroom> getClassRoomDir(){
		return classRoomDir;
	}
}
