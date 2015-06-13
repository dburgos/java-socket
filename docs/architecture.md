# Architecture
## Readme

Please, check the architecture.png file

### Goals
- Modularity
- High scalability
- High availability

### Step by step
- One or more devices send the information via TCP or UDP protocols, but this is open to expand
- All that information are sent to a balancer proxy
- This balancer proxy can be a nginx server, a HAProxy server or similar software
- This balancer proxy will have the server list and will send the request to an available server
- The server, powered by Java, NodeJS or whatever, will process the request
- Then, it will save the processed information to a noSQL database (in this case MongoDb)

### FAQ
#### Why the devices do not send the info directly to the servers?
- If you use directly a server list, the devices can't balance itself.
- And if any device connects to a not available server, you are fucked.
- Can balance the load
- Can scale adding more servers in just one site
- Custom performance settings (server weights, geo balance, etc.)

#### Do I need a MongoDb replicaSet?
Not really, you only need a mongo proccess running

#### So, why I need a MongoDb replicaSet?
- To achieve high availability. In case a server goes down, you will have more server running.
- For security, you will have at least a few copies of your data and you can backup anytime.
Also remember, you must have a mininum of 3 servers to form a MongoDb ReplicaSet

If you have any question or comment, please open a ticket
