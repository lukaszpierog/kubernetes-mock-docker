# kubernetes-mock-docker
Dockerized k8s mock server from fabric8 kubernetes-client (https://github.com/fabric8io/kubernetes-client#mocking-kubernetes)

Mock server works in CRUD mode
Custom resources can be registered at startup by setting env, 
i.e. CUSTOM_KUBERNETES_RESOURCES='package.com/v1alpha1#ObjectConfig,package.com/v1alpha1#OtherConfig'
