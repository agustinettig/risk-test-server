# Risk test server

Works as a mock of the [ClearSale API](https://api.clearsale.com.br/docs/total-totalGarantido-application). Created to be used by internal tests.

## Features
Base URL:
```/v1/api/risks/tests```

### Authenticate:
Basic authentication(mocked)
```POST /authenticate```

### Create order:
Creates the order for analysis and mocks a webhook call to an endpoint notifying the status change.
```POST /orders```

### Check status:
Returns the status based on the document used to create the order
```GET /orders/:orderId/status```