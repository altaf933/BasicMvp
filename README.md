## Synopsis

Android MVP architecture is introduce for make a project flexible, maintainable and easily apply Unit test.
In MVP presenter assume the functionality of the middle man . In MVP all core logic pushed to presentation layer.

Model : It's give a flexibility of how data stored and retrieved . Presentation layer responsible for fetch data from the model
        and provide to a view layer.

View :  It's display data and routes user event to presentation layer.

Presentation : It's middle layer it always keep communicate between model and view layer. It retrive a data from the model and formate it for display in the view.
               Business logic live in the presenter and relies on the view to do Android work.



## Code Example
step 1: create interface  for your view ```IMyView.java```
         
         public interface IMyView {
                 void showItems(List<String> items);
           }         
           
step 2: create interface for your presentation ```IMyServices.java ``` it will notify when long running task finish.
        
        
         public interface IMyServices {
                List<String> getItems();
          }
step 3: create class ```MyContentServices.java ``` usally it's include your long running operation that notify your presenter by                 implement ```IMyServices.java ```.
    
    public class MyContentServices implements IMyServices {
       @Override
       public List<String> getItems() {
         ArrayList<String> items = new ArrayList<>();
         items.add("one");
         items.add("two");
         items.add("three");
         items.add("four");
         return items;
       }
    }
 step 4: Implement ```IMyView.java``` to your ```Activity``` or ```Fragment``` class it will override ```showItems(List<String> items)``` method in Activity.
      
  
 step 5: Now merge all your step into ```Activity.java``` file at any event of your specific view.
          
         private  MyPresenter presenter;
         presenter = new MyPresenter(this, new MyContentServices());
         
           @OnClick(R.id.btnLoad)
            public void loadItems() {
               presenter.load();
           }
         
               
## Motivation

A short description of the motivation behind the creation and maintenance of the project. This should explain **why** the project exists.

## Installation

Provide code examples and explanations of how to get the project.

## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests

Describe and show how to run the tests with code examples.

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)
