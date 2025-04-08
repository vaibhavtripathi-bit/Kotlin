```mermaid
graph TD
    %% Define Layers/Subgraphs
    subgraph "External Services"
        direction RL
        BackendAPI[Backend REST/HTTP API]
        BackendWS[Backend WebSocket Server]
    end

    subgraph "Core Chat Library: Domain"
        direction TB
        subgraph "Use Cases"
            GetChatStateUC[GetChatStateUseCase]
            SendMessageUC[SendMessageUseCase]
        end
        RepoInterface[ChatRepository (Interface)];
        Models[Domain Models (Message)];

        %% Domain Dependencies
        GetChatStateUC --> RepoInterface;
        SendMessageUC --> RepoInterface;
        GetChatStateUC --> Models;
        SendMessageUC --> Models;
    end

    subgraph "Application Layer: Data"
        direction TB
        RepoImpl[ChatRepositoryImpl];
        subgraph "Data Sources"
            DAO[MessageDao (Interface)\n- Room Implementation];
            NetworkDS[MessageNetworkDataSource (Interface)\n- Retrofit/Ktor Implementation];
            RealtimeDS[RealtimeMessageDataSource (Interface)\n- OkHttpWebSocket Implementation];
        end
        Mappers[Mappers\n(DTO <-> Domain <-> Entity)];
        subgraph "Infrastructure"
            RoomDB[(Room Database)];
            OkHttpClient[(OkHttpClient)];
            RetrofitClient[(Retrofit/Ktor Client)];
        end

        %% Data Layer Dependencies
        RepoImpl -- Implements --> RepoInterface;
        RepoImpl --> DAO;
        RepoImpl --> NetworkDS;
        RepoImpl --> RealtimeDS;
        RepoImpl --> Mappers;
        DAO --> RoomDB;
        NetworkDS --> RetrofitClient;
        RealtimeDS --> OkHttpClient;

        %% DTOs/Entities used within Data Layer
        NetworkDS --- DTOs[Network DTOs];
        DAO --- Entities[DB Entities];
        Mappers --> Models & DTOs & Entities;

    end

    %% Define Interactions/Flows

    %% User Actions (Control Flow Down)
    VM -- Calls --> GetChatStateUC;
    VM -- Calls --> SendMessageUC;

    %% Data Observation (Data Flow Up - Arrows indicate data source)
    UI -- Observes State --> VM;
    VM -- Observes Flow --> GetChatStateUC;
    GetChatStateUC -- Observes Flow (via Repo Interface) --> RepoImpl;
    RepoImpl -- Observes Flow --> DAO;


    %% Network/DB Operations (Control Flow Down, Data Flow Back)
    %% Sync/Fetch
    NetworkDS -- HTTP Request --> BackendAPI;
    BackendAPI -- HTTP Response --> NetworkDS;

    %% Send Message
    NetworkDS -- HTTP Request --> BackendAPI;
    BackendAPI -- HTTP Response --> NetworkDS;

    %% Real-time
    RealtimeDS -- WebSocket Connection --> BackendWS;
    BackendWS -- WebSocket Message --> RealtimeDS;


    %% Styling (Optional)
    classDef domain fill:#D6EAF8,stroke:#5DADE2,stroke-width:2px;
    classDef data fill:#D5F5E3,stroke:#58D68D,stroke-width:2px;
    classDef presentation fill:#FDEDEC,stroke:#F1948A,stroke-width:2px;
    classDef external fill:#FEF9E7,stroke:#F4D03F,stroke-width:1px;
    classDef interface stroke-dasharray: 5 5

    class RepoInterface,DAO,NetworkDS,RealtimeDS interface;
    class GetChatStateUC,SendMessageUC,Models domain;
    class RepoImpl,Mappers,RoomDB,OkHttpClient,RetrofitClient,DTOs,Entities data;
    class UI,VM presentation;
    class BackendAPI,BackendWS external;
```
