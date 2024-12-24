# DwitchApp
## Brief Overview of Technical Aspects:
### Authentication:

JWT token used in the "Authorization" header to secure API calls.
The token is retrieved via BuildConfig.apiKey and passed in requests using Retrofit.

### State Management:

UiStateHandler class implements states (Idle, Loading, Success, Error, Empty) to handle UI transitions.
StateFlow is used to observe and react to state changes in the ViewModel.

### ViewModel Management:

One ViewModel per feature (e.g., NewsViewModel for the articles list).
Uses viewModelScope to perform asynchronous tasks (e.g., API calls).
Data retrieval logic is encapsulated within the ViewModel.

### MVVM Concept:

Model: Data handled through Retrofit and Moshi. API responses are wrapped in data classes (e.g., NewsResponse).
View: UI built with Jetpack Compose (e.g., LazyColumn, ListItem).
ViewModel: Centralized business logic and data handling (e.g., NewsViewModel manages state and data for the articles screen).

### Implementation in Code:

MVVM Compliance: The View directly consumes the state (uiState) exposed by the ViewModel.
API calls and data transformations are isolated within the ViewModel, keeping the View clean and reactive.
