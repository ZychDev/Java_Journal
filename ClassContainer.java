import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent;

public class ClassContainer {
    Map<String, Class> groups = new HashMap<String, Class>();

    void addClass(String group, Class newClass) {
        this.groups.put(group, newClass);
    }

    void removeClass(String group) {
        this.groups.remove(group);
    }

    ClassContainer remo(String name, ClassContainer gr) 
    {

        gr.removeClass(name);

        return gr;
    }


    List<Class> findEmpty() {
        List<Class> emptyGroups = new ArrayList<>();
        for (Map.Entry<String, Class> entry : groups.entrySet()) {
            if (entry.getValue().getStudentCount() == 0) emptyGroups.add(entry.getValue());
        }
        return emptyGroups;
    }

    void summary() {
        for (Map.Entry<String, Class> entry : groups.entrySet()) {
            Class c = entry.getValue();
            System.out.println(String.format("\n\nGroup: %s, Students number: %.2f",
                    c.group, (float)c.getStudentCount() ));
        }
    }

    List<String> summaryNames() 
    {
        List<String> GroupsNames = new ArrayList<>();
        for (Map.Entry<String, Class> entry : groups.entrySet()) 
        {
            Class c = entry.getValue();
            GroupsNames.add(c.getGroupName());
        }
        
        return GroupsNames;

    }








    Class GetClass(String name) 
    {
        for (Map.Entry<String, Class> entry : groups.entrySet()) 
        {
            Class c = entry.getValue();
            if(c.getGroupName() == name)
            {
                System.out.println(c.group);
                return c;
            }
          
        }
        return null;
    }







}

