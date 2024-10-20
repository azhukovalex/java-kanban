package models;

public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected TaskStates state;
    
    //Constructors
    public Task(int id, String name, String description, TaskStates state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.state = TaskStates.NEW;
    }
    
    //Getters
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskStates getStatus() {
        return state;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected void setState(TaskStates state) {
        this.state = state;
    }
    
    //Overrides
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task other)) return false;

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public String toString() {
        return "Task {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}

