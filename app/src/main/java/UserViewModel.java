import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private MutableLiveData<String> firstName;
    private MutableLiveData<String> lastName;

    public MutableLiveData<String> getFirstName() {
        if (firstName == null) {
            firstName = new MutableLiveData<>();
        }
        return firstName;
    }

    public MutableLiveData<String> getLastName() {
        if (lastName == null) {
            lastName = new MutableLiveData<>();
        }
        return lastName;
    }
}
