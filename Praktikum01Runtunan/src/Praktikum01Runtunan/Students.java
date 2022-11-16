package Praktikum01Runtunan;

public class Students {
	int NPM;
    String FullName;
    String ClassName;
    int Semester;
    float GPA;

    int getNPM(int val) {
        NPM = val;
        return NPM;
    }

    String getFullName(String val) {
        FullName = val;
        return FullName;
    }

    String getClassName(String val) {
        ClassName = val;
        return ClassName;
    }

    int getSemester(int val) {
        Semester = val;
        return Semester;
    }

    float getGPA(float val) {
        GPA = val;
        return GPA;
    }
    
}
