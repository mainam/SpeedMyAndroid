SpeedView
===================================
    
makes android developing faster


USAGE
===================================

    dependencies {
        compile "me.leolin:SpeedView:0.0.+"
    }

EXAMPLE
===================================
    
    public class MainActivity extends Activity {
    
        private List<Student> students = new LinkedList<>();
        private SpeedListAdapter<Student> studentSpeedListAdapter;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    
            TextView textView = new TextView(this);
            textView.setText("Programmatically created");
    
            students.add(new Student("1", "Steve"));
            students.add(new Student("2", "John"));
            students.add(new Student("3", "Mary"));
            students.add(new Student("4", "Jason"));
    
            studentSpeedListAdapter = new SpeedListAdapter<>(students, R.layout.listitem_student, getLayoutInflater(), (speedView, student) -> {
                speedView
                        .tv(R.id.textViewStudentId).text(student.getId())
                        .tv(R.id.textViewStudentName).text(student.getName());
            });
    
            // @formatter:off
            SpeedView.with(this)
                    .tv(R.id.textView1).text("Hello SpeedView")
                    .tv(R.id.textView2).text(":)").show().text("Amazing!")
                    .btn(R.id.button).text("Click me!")
                        .click(v -> Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show())
                    .container(R.id.container).addView(textView)
                    .list(R.id.listview).adapter( studentSpeedListAdapter)
                        .itemClick((parent, view, position, id) -> Toast.makeText(this, "click position:" + position, Toast.LENGTH_SHORT).show())
                    .view(R.id.textViewWillBeDisappear).hide();
            // @formatter:on
        }
    
    
    }


DEVELOP BY
===================================

Leo Lin([https://github.com/leolin310148](https://github.com/leolin310148))